package com.practice.trywithresources;

/**
 * @author
 * 
 * 		implementing the resource class with AutoClosebale will make sure the
 *         client to implement the Close() method where the resource will be
 *         released and also will throw exception to resource creation class if
 *         the resource close doesn't happen correctly.
 * 
 */
public class CustomResource implements AutoCloseable {

	public void execute() {
		System.out.println("executing resource");
	}

	/* (non-Javadoc)
	 * @see java.lang.AutoCloseable#close()
	 */
	@Override
	public void close() throws Exception {

		System.out.println("Resource is closing");

	}

}
