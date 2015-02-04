package com.anduadnu.validator;

import com.anduadnu.validtors.PasswordValidator;

import junit.framework.Assert;
import junit.framework.TestCase;

public class PasswordValidatorTest extends TestCase {

	private PasswordValidator passwordValidator;
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		setPasswordValidator(new PasswordValidator());
		
	}
	public void testalidInValidPasswordNumberMissing() {
		Assert.assertFalse(getPasswordValidator().validate("testpass"));
	}
	public void testalidInValidPasswordLargePassword() {
		Assert.assertFalse(getPasswordValidator().validate("testpass123456789"));
	}
	public void testalidInValidPasswordSmallPassword() {
		Assert.assertFalse(getPasswordValidator().validate("tet1"));
	}
	public void testalidInValidPasswordLowercaseCharacterMissing() {
		Assert.assertFalse(getPasswordValidator().validate("TESTPASS1"));
	}
	
	public void testalidInValidPasswordUppercaseCharacterMissing() {
		Assert.assertFalse(getPasswordValidator().validate("testpass1"));
	}
	
	public void testalidInValidPasswordSpecialCharacterMissing() {
		Assert.assertFalse(getPasswordValidator().validate("Testpass1"));
	}
	
	public void testalidPasswordWithMinLengthWithMaxLength() {
		Assert.assertTrue(getPasswordValidator().validate("Test_a$s1_"));
	}
	
	public void testalidPasswordWithMinLength() {
		Assert.assertTrue(getPasswordValidator().validate("Tet1_"));
	}
	
	public void testalidPassword() {
		Assert.assertTrue(getPasswordValidator().validate("Testss1_"));
	}
	
	public PasswordValidator getPasswordValidator() {
		return passwordValidator;
	}
	public void setPasswordValidator(PasswordValidator passwordValidator) {
		this.passwordValidator = passwordValidator;
	}
	
}
