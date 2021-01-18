package com.niton.reactj.swing.components;

import com.niton.reactj.ReactiveBinder;
import com.niton.reactj.ReactiveBinder.Converter;
import com.niton.reactj.swing.JTextComponentExtension;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.io.File;

public class JRFormattedTextField extends JFormattedTextField implements JTextComponentExtension {
	@Override
	public JTextComponent getThis() {
		return this;
	}
	public void bindValue(String property, ReactiveBinder binder){
		binder.bind(property,this::setValue);
	}
	public void biBindValue(String property, ReactiveBinder binder){
		binder.bindBi(property,this::setValue,this::getValue);
		addActionListener(binder::react);
	}
	public <T> void bindValue(String property, ReactiveBinder binder, Converter<T, Object> converter){
		binder.bind(property,this::setValue,converter);
	}
	public <T> void biBindValue(String property, ReactiveBinder binder, Converter<T,Object> toDisplay, Converter<Object,T> toModel){
		binder.bindBi(property,this::setValue,this::getValue,toModel,toDisplay);
		addActionListener(binder::react);
	}
	public void bindFormatter(String property, ReactiveBinder binder){
		binder.bind(property,this::setFormatter);
	}

	public <T> void bindFormatter(String property, ReactiveBinder binder, Converter<T, AbstractFormatter> converter){
		binder.bind(property,this::setFormatter,converter);
	}
}
