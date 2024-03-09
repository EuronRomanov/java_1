package com.cmc.repaso.test;

import com.cmc.repaso.entidades.Item;

public class TestItem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Item item1=new Item();
item1.setNombre("papel");
item1.setProductosActuales(20);
item1.setProductosDevueltos(20);
item1.setProductosVendidos(20);

item1.imprimir();
item1.vender(10);
item1.imprimir();


System.out.println("--------------");
Item item2=new Item();
item2.setNombre("lapices");
item2.setProductosActuales(30);
item2.setProductosDevueltos(30);
item2.setProductosVendidos(30);

item2.imprimir();
item2.vender(5);
item2.imprimir();



	}

}
