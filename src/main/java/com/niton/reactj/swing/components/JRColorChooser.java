package com.niton.reactj.swing.components;

import com.niton.reactj.ReactiveBinder;
import com.niton.reactj.swing.JComponentExtension;

import javax.swing.*;
import java.awt.*;

public class JRColorChooser extends JColorChooser implements JComponentExtension<JColorChooser> {
	@Override
	public JColorChooser getThis() {
		return this;
	}
	public void bindColor(String property, ReactiveBinder binder){
		binder.<Color>bind(property,getThis()::setColor);
	}

	public <T> void bindColor(String property, ReactiveBinder.Converter<T,Color> converter, ReactiveBinder binder){
		binder.bind(property,getThis()::setColor,converter);
	}


	public void biBindColor(String property, ReactiveBinder binder){
		binder.bindBi(property,getThis()::setColor,getThis()::getColor);
		addPropertyChangeListener("color",binder::react);
	}

	public <T> void biBindColor(String property, ReactiveBinder.Converter<T,Color> toDisplayConverter, ReactiveBinder.Converter<Color,T> toModelConverter, ReactiveBinder binder){
		binder.bindBi(property,getThis()::setColor,getThis()::getColor,toModelConverter,toDisplayConverter);
		addPropertyChangeListener("color",binder::react);
	}
}
