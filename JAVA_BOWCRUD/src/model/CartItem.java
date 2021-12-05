package model;

import java.util.List;

public class CartItem {
	public item addPro(String id){
		item item = new item();
		
		Product pro = new Product().find(id);
		item.setId(id);
		item.setPrice(pro.getPrice());
		item.setPro(pro);
		item.setQty(1);
		
		return item;
	}
	public List<item> updateCart(String id, List<item> list) {
		boolean flag = true;
		
		for(item itemPro:list) {

			if(itemPro.getId().equalsIgnoreCase(id)) {
				itemPro.setQty(itemPro.getQty()+1);
				flag = false;
			}
		}
		if(flag) {
			list.add(addPro(id));
		}
		return list;
	}
}
