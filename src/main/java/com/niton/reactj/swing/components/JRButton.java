package com.niton.reactj.swing.components;

import com.niton.reactj.swing.JButtonExtension;

import javax.swing.*;

public class JRButton extends JButton implements JButtonExtension {
	@Override
	public JButton getThis() {
		return this;
	}

	public JRButton() {
	}

	public JRButton(Action a) {
		super(a);
	}
}
