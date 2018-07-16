package com.practice.trywithresources;

public class TryWithResourceTester {

	/**
	 * @param args
	 * 
	 * 
	 *            The resource that is created here in try() will be closed
	 *            automatically when try block is exited , this will be done by
	 *            invoking close() by JVM automatically.
	 * 
	 *            catch and finally block will execute if they exist normally but
	 *            after the resource is closed.
	 * 
	 *            Many Java standard library classes which are resources already
	 *            implemented AutoClosable and closes the resources if they have
	 *            declared as part of try-with resources
	 * 
	 *            The Close() method is auto invoked here by compiler and hence it
	 *            forces to surround with catch or to throw exception
	 * 
	 */
	public static void main(String[] args) {

		try (CustomResource cr = new CustomResource()) {
			cr.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
