package org.rage.swarm;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.ClassLoaderAsset;
import org.rage.swam.delegate.TrikitruDelegateImpl;
import org.rage.swarm.rest.SimpleRest;
import org.wildfly.swarm.container.Container;
import org.wildfly.swarm.jaxrs.JAXRSArchive;

public class Main {

	public static void main(String[] args) {
		try {
			Container container = new Container();
			container.start();

			JAXRSArchive deployment = ShrinkWrap.create(JAXRSArchive.class);
			// Classes or packages
			deployment.addResource(SimpleRest.class);
			deployment.addPackage(TrikitruDelegateImpl.class.getPackage());
			// Resources
			deployment.addAsWebInfResource(new ClassLoaderAsset("META-INF/beans.xml", Main.class.getClassLoader()),
					"classes/META-INF/beans.xml");

			container.deploy(deployment);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
