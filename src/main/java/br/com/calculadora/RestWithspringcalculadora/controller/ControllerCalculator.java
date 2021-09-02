package br.com.calculadora.RestWithspringcalculadora.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class ControllerCalculator {

	@GetMapping("/sum/numberOne/numberTwo")
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo ) throws Exception {
		Double sum;
		if(isNumeric(numberOne) && isNumeric(numberTwo) ) {
			 sum = Double.parseDouble(numberOne)+Double.parseDouble(numberOne);
		}else {
			throw new Exception();
			
		}
		
		return sum;
	}

	private boolean isNumeric(String strNumber) {
		if(strNumber == null) return false;
		String number = strNumber.replaceAll(",",".");
		return number.matches("[-+]?[0-9]*\\\\.?[0-9]+");
	}
	
}
