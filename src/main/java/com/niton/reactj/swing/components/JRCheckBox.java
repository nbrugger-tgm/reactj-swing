package com.niton.reactj.swing.components;

import com.niton.reactj.ReactiveBinder;
import com.niton.reactj.ReactiveBinder.Converter;
import com.niton.reactj.swing.JButtonExtension;

import javax.swing.*;

public class JRCheckBox extends JCheckBox implements JButtonExtension {
	@Override
	public JCheckBox getThis() {
		return this;
	}

	public JRCheckBox() {
	}

	public void biBindSelected(String property, ReactiveBinder binder){
		binder.bindBi(property,this::setSelected,this::isSelected);
		addActionListener(binder::react);
	}

	public <T> void biBindSelected(String property, ReactiveBinder binder, Converter<T,Boolean> toUI, Converter<Boolean,T> toModel){
		binder.bindBi(property,this::setSelected,this::isSelected,toModel,toUI);
		addActionListener(binder::react);
	}

	public JRCheckBox(Action a) {
		super(a);
	}
}
