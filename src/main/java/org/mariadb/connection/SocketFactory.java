package org.mariadb.connection;

import com.google.cloud.sql.core.CoreSocketFactory;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Properties;

public class SocketFactory extends javax.net.SocketFactory {

	private Properties props = new Properties();

	public SocketFactory(){
		props.put(CoreSocketFactory.CLOUD_SQL_INSTANCE_PROPERTY, System.getenv("cloudSqlInstance"));
	}

	@Override
	public Socket createSocket() throws IOException {
		return CoreSocketFactory.connect(props, CoreSocketFactory.MYSQL_SOCKET_FILE_FORMAT);
	}

	@Override
	public Socket createSocket(String s, int i) throws IOException, UnknownHostException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Socket createSocket(String s, int i, InetAddress inetAddress, int i1) throws IOException, UnknownHostException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress1, int i1) throws IOException {
		throw new UnsupportedOperationException();
	}
}
