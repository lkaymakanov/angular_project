package com.example.demo;

import net.is_bg.ltf.db.common.interfaces.logging.ILog;
import net.is_bg.ltf.db.common.interfaces.logging.ILogFactory;

public class EmptyLogFactory implements ILogFactory {

	@Override
	public ILog getLog(Class<?> arg0) {
		// TODO Auto-generated method stub
		return new ILog() {
			
			@Override
			public void warn(Object arg0, Throwable arg1) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void warn(Object arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void trace(Object arg0, Throwable arg1) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void trace(Object arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean isWarnEnabled() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isTraceEnabled() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isInfoEnabled() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isFatalEnabled() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isErrorEnabled() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isDebugEnabled() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void info(Object arg0, Throwable arg1) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void info(Object arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void fatal(Object arg0, Throwable arg1) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void fatal(Object arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void error(Object arg0, Throwable arg1) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void error(Object arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void debug(Object arg0, Throwable arg1) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void debug(Object arg0) {
				// TODO Auto-generated method stub
				
			}
		};
	}

}
