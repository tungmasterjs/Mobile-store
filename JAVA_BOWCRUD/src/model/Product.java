package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Product {
	private String item_code,category,name,image,des,manu;
	private int id,price,units_in_stock,condition;
	
	
	public String getItem_code() {
		return item_code;
	}
	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getManu() {
		return manu;
	}
	public void setManu(String manu) {
		this.manu = manu;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getUnits_in_stock() {
		return units_in_stock;
	}
	public void setUnits_in_stock(int units_in_stock) {
		this.units_in_stock = units_in_stock;
	}
	public int getCondition() {
		return condition;
	}
	public void setCondition(int condition) {
		this.condition = condition;
	}
	
	public List<Product> getList(){
		List<Product> list = new ArrayList<Product>();
		
		try {
			Class.forName(ConnectDB.jdbc_driver);
			Connection cn = DriverManager.getConnection(ConnectDB.url,ConnectDB.user,ConnectDB.pass);
			String sql = "select * from product";
			PreparedStatement ps =cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Product pro = new Product();
					pro.setId((Integer.parseInt(rs.getString("Id_product"))));
					pro.setItem_code(rs.getString("item_code"));
					pro.setName(rs.getString("Name"));
					pro.setImage(rs.getString("Image"));
					pro.setManu(rs.getString("Manufacturer"));
					pro.setDes(rs.getString("Des"));
					pro.setCategory((rs.getString("category")));
					pro.setPrice(rs.getInt("Unit_price"));
					pro.setUnits_in_stock(rs.getInt("Units_in_stock"));
					pro.setCondition(rs.getInt("ConditionPro"));
				list.add(pro);
			}
			rs.close();
			ps.close();
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public Product find(String item_code) {
		Product pro = new Product();
		try {
			Class.forName(ConnectDB.jdbc_driver);
			Connection cn = DriverManager.getConnection(ConnectDB.url,ConnectDB.user,ConnectDB.pass);
			String sql = "select * from product where item_code=?";
			PreparedStatement ps =cn.prepareStatement(sql);
			ps.setString(1, item_code);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				pro.setId(rs.getInt("Id_product"));
				pro.setItem_code(rs.getString("item_code"));
				pro.setName(rs.getString("Name"));
				pro.setImage(rs.getString("Image"));
				pro.setManu(rs.getString("Manufacturer"));
				pro.setDes(rs.getString("Des"));
				pro.setCategory((rs.getString("category")));
				pro.setPrice(rs.getInt("Unit_price"));
				pro.setUnits_in_stock(rs.getInt("Units_in_stock"));
				pro.setCondition(rs.getInt("ConditionPro"));
			}
			rs.close();
			ps.close();
			cn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return pro;
	}
	public void addProduct() {
		Random rd = new Random();
		String[] number = {"0","1","2","3","4","5","6","7","8","9"};
		String item_code= "";
		for(int i = 0;i < 13;i++) {
			int id = rd.nextInt(9 - 0 + 1) + 0;
			item_code += number[id];
		}

		try {
			Class.forName(ConnectDB.jdbc_driver);
			Connection cn = DriverManager.getConnection(ConnectDB.url,ConnectDB.user,ConnectDB.pass);
			String sql = "insert into product(category, item_code, Name, Image, Des, Units_in_stock, Unit_price, Manufacturer, ConditionPro) values(?,?,?,?,?,?,?,?,?)";//Id_product,Id_category,Name_product,Image_product,Description_product,Units_in_stock_product,Unit_price_product,Manufacturer,ConditionPro
			PreparedStatement ps =cn.prepareStatement(sql);
			ps.setString(1, this.getCategory());
			ps.setString(2, item_code);
			ps.setString(3, this.getName());
			ps.setString(4, this.getImage());
			ps.setString(5, this.getDes());
			ps.setInt(6, this.getUnits_in_stock());
			ps.setInt(7, this.getPrice());
			ps.setString(8, this.getManu());
			ps.setInt(9, this.getCondition());
			int i = ps.executeUpdate();
			if(i!=0)
				System.out.println("Thành công");
			else
				System.out.println("Thất bại");
			
			ps.close();
			cn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();}	

	}
}
