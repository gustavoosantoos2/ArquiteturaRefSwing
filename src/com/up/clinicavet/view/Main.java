package com.up.clinicavet.view;

import com.up.clinicavet.controller.ViewPrincipalController;

public class Main {

	public static void main(String[] args) {
		ViewPrincipal view = new ViewPrincipal();
		ViewPrincipalController controller = new ViewPrincipalController(view);
		view.setVisible(true);
	}

}
