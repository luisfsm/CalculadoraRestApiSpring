package br.com.calculadora.RestWithspringcalculadora.controller;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.calculadora.RestWithspringcalculadora.Exception.UnsuportedMathOperationException;

@RestController
public class ControllerCalculator {

	@RequestMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo ) throws Exception {
		Double sum;
		if(isNumeric(numberOne) && isNumeric(numberTwo) ) {
			System.out.println(numberOne);
			System.out.println(numberTwo);
			 sum = Double.parseDouble(numberOne)+Double.parseDouble(numberOne);
		}else {
			throw new UnsuportedMathOperationException("Please with value numeric!");
			
		}
		return sum;
	}
	
	@RequestMapping("/min/{numberOne}/{numberTwo}")
	public Double min(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
		Double min;
		if(isNumeric(numberOne) && isNumeric(numberTwo)) {
			min = Double.parseDouble(numberOne) - Double.parseDouble(numberTwo);
		}else {
			throw new UnsuportedMathOperationException("Please with value numeric");
		}
		return min;
	}
	
	@RequestMapping("/div/{numberOne}/{numberTwo}")
	public String div(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
		Double div;
		
		if(isNumeric(numberOne) && isNumeric(numberTwo)) {
			div = Double.parseDouble(numberOne)/Double.parseDouble(numberTwo);
		}else {
			throw new UnsuportedMathOperationException("Please with value numeric");
		}
		NumberFormat number = new DecimalFormat("#0.00");
		return number.format(div);
		
	}
	
	@RequestMapping("/multi/{numberOne}/{numberTwo}")
	public Double multi(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
			Double multi;
			
			if(isNumeric(numberOne) && isNumeric(numberTwo)) {
				multi = Double.parseDouble(numberOne)*Double.parseDouble(numberTwo);
			}else {
				throw new UnsuportedMathOperationException("Please with value numeric");
			}
			
			return multi;
	}

	private boolean isNumeric(String strNumber) {
		if(strNumber == null) return false;
		String number = strNumber.replaceAll(",",".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
	
}
