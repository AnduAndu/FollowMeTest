package com.anduadnu.validator;

import com.anduadnu.validtors.EmailValidator;

import junit.framework.Assert;
import junit.framework.TestCase;

public class EmailVaildatorTest extends TestCase {

	private EmailValidator emailValidator;
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		setEmailValidator(new EmailValidator());
	}
	
	public void testInValidEmail1() {
		Assert.assertFalse(getEmailValidator().validate("@.com"));
	}
	
	public void testInValidEmail2() {
		Assert.assertFalse(getEmailValidator().validate("test@.com"));
	}

	public void testInValidEmail3() {
		Assert.assertFalse(getEmailValidator().validate("Joe Smith <email@example.com>"));
	}
	
	public void testInValidEmail4() {
		Assert.assertFalse(getEmailValidator().validate("email@example@example.com"));
	}
	
	public void testInValidEmail5() {
		Assert.assertFalse(getEmailValidator().validate("email.example.com"));
	}
	
	public void testValidEmail1() {
		Assert.assertTrue(getEmailValidator().validate("test.abc@xyz.com"));
	}
	
	public void testValidEmail2() {
		Assert.assertTrue(getEmailValidator().validate("test@xyz.com"));
	}
	
	public void testValidEmail3() {
		Assert.assertTrue(getEmailValidator().validate("email@subdomain.example.com"));
	}
	
	public void testValidEmail4() {
		Assert.assertTrue(getEmailValidator().validate("firstname-lastname@example.com"));
	}
	
	public EmailValidator getEmailValidator() {
		return emailValidator;
	}
	public void setEmailValidator(EmailValidator emailValidator) {
		this.emailValidator = emailValidator;
	}

	
}
