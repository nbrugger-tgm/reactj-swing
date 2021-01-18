package com.niton.reactj.swing.components;

import com.niton.reactj.ReactiveBinder;
import com.niton.reactj.ReactiveBinder.Converter;
import com.niton.reactj.swing.JComponentExtension;

import javax.swing.*;
import java.util.Arrays;

public class JRComboBox<E> extends JComboBox<E> implements JComponentExtension<JComboBox<E>> {
	private DefaultComboBoxModel<E> data = new DefaultComboBoxModel<>();

	@Override
	public JComboBox<E> getThis() {
		return this;
	}

	public JRComboBox() {
		super.setModel(data);
	}

	/**
	 * <h2>DO NOT USE THIS FUNCTION</h2>
	 * <p>
	 *     The model of a JRCombo box is fixed and cannot be changed. Calling this method will raise a {@link UnsupportedOperationException}
	 * </p>
	 * @param aModel the model <b>NOT</b> to set
	 * @throws UnsupportedOperationException every single time
	 */
	@Override
	public void setModel(ComboBoxModel<E> aModel) throws UnsupportedOperationException{
		throw new java.lang.UnsupportedOperationException("setModel is not allowed to be called on JRComboBox. Use bindings instead");
	}

	public <T> void bindEditable(String property, Converter<T,Boolean> converter, ReactiveBinder binder){
		binder.bind(property,this::setEditable,converter);
	}
	public void bindEditable(String property, ReactiveBinder binder){
		binder.bind(property,this::setEditable);
	}
	public <T> void biBindSelectedItem(String property, Converter<T, E> toDisplayConverter, Converter<E,T> toModelConverter, ReactiveBinder binder){
		binder.bindBi(property,
		              this::setSelectedItem,
		              ()->(E)getSelectedItem(),
		              toModelConverter,
		              toDisplayConverter);
		addActionListener(binder::react);
	}
	public <T> void biBindSelectedItem(String property, ReactiveBinder binder){
		binder.bindBi(property,data::setSelectedItem,this::getSelectedItem);
		addActionListener(binder::react);
	}
	public <T> void biBindSelectedIndex(String property, ReactiveBinder binder){
		binder.bindBi(property,data::setSelectedItem,this::getSelectedItem);
		addActionListener(binder::react);
	}
	public void bindOptions(String property, ReactiveBinder binder){
		binder.<E[]>bind(property,(e) -> super.setModel(data = new DefaultComboBoxModel<>(e)));
	}

	public <T> void bindAndMapOptions(String property, Converter<T,E> itemConverter, ReactiveBinder binder){
		binder.<T[],E[]>bind(
				property,
				(e) -> super.setModel(data = new DefaultComboBoxModel<>(e)),
				toConvert -> (E[])Arrays.stream(toConvert).map(itemConverter::convertTypesave).toArray()
		);
	}
	public <T> void bindOptions(String property, Converter<T,E[]> converter, ReactiveBinder binder){
		binder.bind(
				property,
				(e) -> super.setModel(data = new DefaultComboBoxModel<>(e)),
				converter
		);
	}
}
