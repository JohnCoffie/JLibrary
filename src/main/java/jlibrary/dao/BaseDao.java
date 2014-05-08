package jlibrary.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface BaseDao {   
    
    public Object find(String queryString,Object[] values);   
       
    public List findList(String queryString, Object[] values);   
       
    public List getAllObject(Class clazz);   
       
    public Object getObject(Class clazz, Serializable id);   
       
    public void saveObject(Object o);   
       
    public void removeObject(Class clazz, Serializable id);   
       
    public void removeObject(Object o);   
       
    public void removeAllObject(Collection collection);   
       
    public Object findBy(Class clazz , String name, Object value);   
       
    public List findLike(Class clazz, String name, String value);   
       
    public List findAllBy(Class clazz , String name, Object value);   
       
    public void flush();   
       
}  
