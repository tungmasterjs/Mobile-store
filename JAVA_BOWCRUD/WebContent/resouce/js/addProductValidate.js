$(document).ready(function(){
				$('#myForm').on('submit',function(e){
					
					var name = $('#name').val();
					var price = $('#price').val();
					var unit_in_stock = $('#unit_in_stock').val();
					var des = $('#des').val();
					var manu = $('#manu').val();
					var cate = $('#cate').val();
					var image = $('#image').val();
					
					if(name==""){
						$('#Error').html('Vui lòng không bỏ trống tên sản phẩm');
						e.preventDefault();
						$('#name').focus();
						return;
					}
					if(price==""){
						$('#Error').html('Vui lòng không bỏ trống giá');
						e.preventDefault();
						$('#price').focus();
						return;
					}
					if(unit_in_stock==""){
						$('#Error').html('Vui lòng không bỏ trống số lượng');
						e.preventDefault();
						$('#unit_in_stock').focus();
						return;
					}
					if(des==""){
						$('#Error').html('Vui lòng không bỏ trống mô tả');
						e.preventDefault();
						$('#des').focus();
						return;
					}
					if(manu==""){
						$('#Error').html('Vui lòng không bỏ trống nhà máy sản xuất');
						e.preventDefault();
						$('#manu').focus();
						return;
					}
					if(cate==""){
						$('#Error').html('Vui lòng không bỏ trống loại');
						e.preventDefault();
						$('#cate').focus();
						return;
					}
					if(image==""){
						$('#Error').html('Vui lòng không bỏ trống image');
						e.preventDefault();
						$('#image').focus();
						return;
					}
					
				});
			});