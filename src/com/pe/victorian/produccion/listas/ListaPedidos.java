package com.pe.victorian.produccion.listas;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import com.victorian.produccion.domain.Pedido;

public class ListaPedidos<T extends Pedido> extends ListDataModel<T> implements SelectableDataModel<T> {

	public ListaPedidos(List<T> data) {
		super(data);
	}

	@Override
	public T getRowData(String rowKey) {
		List<T> list = (List<T>) getWrappedData();

		for (T ejb : list) {
			if (ejb.getIdpedido() == (new Integer(rowKey))) {
				return ejb;
			}
		}
		return null;
	}

	@Override
	public Object getRowKey(T item) {
		// TODO Auto-generated method stub
		return item.getIdpedido();
	}

}
