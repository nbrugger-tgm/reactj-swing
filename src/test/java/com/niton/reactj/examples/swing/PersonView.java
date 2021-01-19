package com.niton.reactj.examples.swing;

import com.niton.reactj.ReactiveBinder;
import com.niton.reactj.ReactiveProxy;
import com.niton.reactj.mvc.EventManager;
import com.niton.reactj.mvc.ReactiveView;
import com.niton.reactj.annotation.Reactive;
import com.niton.reactj.swing.JRComponent;
import com.niton.reactj.swing.components.JRComboBox;
import com.niton.reactj.swing.components.JRTextField;

import javax.swing.*;
import java.awt.*;

public class PersonView extends JRComponent<ReactiveProxy<Person>> {

	private JPanel panel;

	private JRTextField        surnameInput;
	private JRTextField        ageInput;
	private JRTextField        iqField;
	private JRComboBox<Gender> genderJComboBox;
	private JButton           selectButton;
	public final EventManager<Person> resetEvent = new EventManager<>();


	@Override
	protected JPanel createView() {
		panel = new JPanel();
		surnameInput = new JRTextField();
		ageInput = new JRTextField();
		iqField = new JRTextField();
		genderJComboBox = new JRComboBox<>();
		genderJComboBox.setModel(new DefaultComboBoxModel<>(Gender.values()));
		selectButton = new JButton("Reset");

		surnameInput.setColumns(10);
		ageInput.setColumns(10);
		iqField.setColumns(10);

		panel.add(surnameInput);
		panel.add(ageInput);
		panel.add(iqField);
		panel.add(genderJComboBox);
		panel.add(selectButton);

		return panel;
	}

	@Override
	public void createBindings(ReactiveBinder binder) {
		surnameInput.biBindText("surename", binder);

		//bind with value conversion
		//UI cannot change IQ
		iqField.bindText("iq",String::valueOf,binder);

		genderJComboBox.biBindSelectedItem("gender",binder);


		//react to changes in many and different ways
		binder.bind("gender", this::adaptColorToGender);

		//bidirectional binding (With value conversion)
		ageInput.biBindText("age", String::valueOf, Integer::parseInt,binder);
		ageInput.addActionListener(binder::react);
	}


	public void adaptColorToGender(Gender g) {
		panel.setBackground(g == Gender.MALE ? Color.BLUE : (g == Gender.FEMALE ? Color.PINK : Color.WHITE));
	}

	@Override
	protected void registerListeners() {
		selectButton.addActionListener(e -> resetEvent.fire(getController().getModel().getObject()));
	}

	@Reactive("age")
	public void adaptSizeToAge(int age) {
		System.out.println("adapt font size for age of " + age + " years");
	}

}
