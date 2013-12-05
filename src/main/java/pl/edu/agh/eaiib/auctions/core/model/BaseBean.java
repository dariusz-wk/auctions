package pl.edu.agh.eaiib.auctions.core.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.datatype.XMLGregorianCalendar;

public abstract class BaseBean<S extends Serializable> {
	public abstract S getId();
	
}
