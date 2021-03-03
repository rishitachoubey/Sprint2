package com.cg.onlinegrocery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
	@RestController
	public class CustomResponseEntityHandler extends ResponseEntityExceptionHandler {
		@ExceptionHandler
		public ResponseEntity<Object> handleOrderIdException(OrderIdException ex, WebRequest request){
			OrderIdExceptionResponse orderIdExceptionResponse =  new OrderIdExceptionResponse(ex.getMessage());
			return new ResponseEntity<Object>(orderIdExceptionResponse,HttpStatus.BAD_REQUEST);
		}	
		
		@ExceptionHandler
		public ResponseEntity<Object> handleOrderNotFoundException(OrderNotFoundException ex, WebRequest request){
			OrderNotFoundExceptionResponse orderNotFoundExceptionResponse =  new OrderNotFoundExceptionResponse(ex.getMessage());
			return new ResponseEntity<Object>(orderNotFoundExceptionResponse,HttpStatus.BAD_REQUEST);
		}

		
		@ExceptionHandler
		public ResponseEntity<Object> handleItemNotFoundException(ItemNotFoundException ex, WebRequest request){
			ItemNotFoundExceptionResponse itemNotFoundExceptionResponse =  new ItemNotFoundExceptionResponse(ex.getMessage());
			return new ResponseEntity<Object>(itemNotFoundExceptionResponse,HttpStatus.BAD_REQUEST);
	}

		@ExceptionHandler
		public ResponseEntity<Object> handlerUserIdException(UserIdException ex,WebRequest request){
			UserIdExceptionResponse userIdExceptionResponse = new UserIdExceptionResponse(ex.getMessage());
					return new ResponseEntity<Object>(userIdExceptionResponse,HttpStatus.BAD_REQUEST);
			
		}
		
		@ExceptionHandler
		public ResponseEntity<Object> handlerUserNotFoundException(UserNotFoundException exm,WebRequest rq)
		{
			UserNotFoundExceptionResponse userNotFoundExceptionResponse=new UserNotFoundExceptionResponse(exm.getMessage());
			return new ResponseEntity<Object>(userNotFoundExceptionResponse,HttpStatus.BAD_REQUEST);
		}
		
		@ExceptionHandler
		public ResponseEntity<Object> handleReviewNotFoundException(ReviewNotFoundException ex, WebRequest request){
			ReviewNotFoundExceptionResponse reviewNotFoundExceptionResponse =  new ReviewNotFoundExceptionResponse(ex.getMessage());
			return new ResponseEntity<Object>(reviewNotFoundExceptionResponse,HttpStatus.BAD_REQUEST);
		}
		
		@ExceptionHandler
		public ResponseEntity<Object> handleTrackingStatusException(TrackingStatusException ex, WebRequest request){
			TrackingStatusExceptionResponse trackingStatusExceptionResponse =  new TrackingStatusExceptionResponse(ex.getMessage());
			return new ResponseEntity<Object>(trackingStatusExceptionResponse,HttpStatus.BAD_REQUEST);
		}	
		
		@ExceptionHandler
		public ResponseEntity<Object> handleTrackingStatusNotFoundException(TrackingStatusNotFoundException ex, WebRequest request){
			TrackingStatusNotFoundExceptionResponse trackingStatusNotFoundExceptionResponse =  new TrackingStatusNotFoundExceptionResponse(ex.getMessage());
			return new ResponseEntity<Object>(trackingStatusNotFoundExceptionResponse,HttpStatus.BAD_REQUEST);
		}
		
		

}