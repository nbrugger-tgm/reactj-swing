package com.niton.reactj.swing.components;

import com.niton.reactj.ReactiveBinder;
import com.niton.reactj.ReactiveBinder.Converter;
import com.niton.reactj.swing.JComponentExtension;

import javax.swing.*;
import java.io.File;

public class JRFileChooser extends JFileChooser implements JComponentExtension<JFileChooser> {

	@Override
	public JFileChooser getThis() {
		return this;
	}
	public void bindApproveButtonText(String property, ReactiveBinder binder){
		binder.bind(property,this::setApproveButtonText);
	}

	public void bindCurrentDirectory(String property, ReactiveBinder binder){
		binder.bind(property,this::setCurrentDirectory);
	}
	public <T> void  bindCurrentDirectory(String property, ReactiveBinder binder, Converter<T, File> converter){
		binder.bind(property,this::setCurrentDirectory,converter);
	}

	public void bindControlButtonsAreShown(String property, ReactiveBinder binder){
		binder.bind(property,this::setControlButtonsAreShown);
	}
	public <T> void bindControlButtonsAreShown(String property, ReactiveBinder binder, Converter<T,Boolean> converter){
		binder.bind(property,this::setControlButtonsAreShown,converter);
	}

	public void bindDialogTitle(String property, ReactiveBinder binder){
		binder.bind(property,this::setDialogTitle);
	}

	public void bindSelectedFile(String property, ReactiveBinder binder){
		binder.bind(property,this::setSelectedFile);
	}
	public void biBindSelectedFile(String property, ReactiveBinder binder){
		binder.bindBi(property,this::setSelectedFile,this::getSelectedFile);
		addActionListener(binder::react);
	}
	public <T> void bindSelectedFile(String property, ReactiveBinder binder, Converter<T,File> converter){
		binder.bind(property,this::setSelectedFile,converter);
	}
	public <T> void biBindSelectedFile(String property, ReactiveBinder binder, Converter<T,File> toDisplay, Converter<File,T> toModel){
		binder.bindBi(property,this::setSelectedFile,this::getSelectedFile,toModel,toDisplay);
		addActionListener(binder::react);
	}

	public void bindSelectedFiles(String property, ReactiveBinder binder){
		binder.bind(property,this::setSelectedFiles);
	}
	public void biBindSelectedFiles(String property, ReactiveBinder binder){
		binder.bindBi(property,this::setSelectedFiles,this::getSelectedFiles);
		addActionListener(binder::react);
	}
	public <T> void bindSelectedFiles(String property, ReactiveBinder binder, Converter<T,File[]> converter){
		binder.bind(property,this::setSelectedFiles,converter);
	}
	public <T> void biBindSelectedFiles(String property, ReactiveBinder binder, Converter<T,File[]> toDisplay, Converter<File[],T> toModel){
		binder.bindBi(property,this::setSelectedFiles,this::getSelectedFiles,toModel,toDisplay);
		addActionListener(binder::react);
	}
}
