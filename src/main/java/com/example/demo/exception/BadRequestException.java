package com.example.demo.exception; 
public class BadRequestException extends RuntimeException { public 
BadRequestException(String msg) { super(msg); } } 
 
resourcenotfound.java 
package com.example.demo.exception; 
public class ResourceNotFoundException extends RuntimeException { public 
ResourceNotFoundException(String msg) { super(msg); } }