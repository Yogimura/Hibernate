package DP_Java.Types;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.jdbc.Size;
import org.hibernate.engine.spi.Mapping;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.type.*;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class PhoneNumberType implements BasicType {

    @Override
    public int[] sqlTypes(Mapping mapping) throws MappingException {
        return new int[]{
                IntegerType.INSTANCE.sqlType(),
                IntegerType.INSTANCE.sqlType(),
                StringType.INSTANCE.sqlType()
        };
    }

    @Override
    public Class<PhoneNumber> getReturnedClass() {
        return PhoneNumber.class;
    }

    @Override
    public String[] getRegistrationKeys() {
        return new String[0];
    }

    @Override
    public boolean isAssociationType() {
        return false;
    }

    @Override
    public boolean isCollectionType() {
        return false;
    }

    @Override
    public boolean isEntityType() {
        return false;
    }

    @Override
    public boolean isAnyType() {
        return false;
    }

    @Override
    public boolean isComponentType() {
        return false;
    }

    @Override
    public int getColumnSpan(Mapping mapping) throws MappingException {
        return 0;
    }

    @Override
    public Size[] dictatedSizes(Mapping mapping) throws MappingException {
        return new Size[0];
    }

    @Override
    public Size[] defaultSizes(Mapping mapping) throws MappingException {
        return new Size[0];
    }

    @Override
    public boolean isSame(Object o, Object o1) throws HibernateException {
        return false;
    }

    @Override
    public boolean isEqual(Object o, Object o1) throws HibernateException {
        return false;
    }

    @Override
    public boolean isEqual(Object o, Object o1, SessionFactoryImplementor sessionFactoryImplementor) throws HibernateException {
        return false;
    }

    @Override
    public int getHashCode(Object o) throws HibernateException {
        return 0;
    }

    @Override
    public int getHashCode(Object o, SessionFactoryImplementor sessionFactoryImplementor) throws HibernateException {
        return 0;
    }

    @Override
    public int compare(Object o, Object o1) {
        return 0;
    }

    @Override
    public boolean isDirty(Object o, Object o1, SharedSessionContractImplementor sharedSessionContractImplementor) throws HibernateException {
        return false;
    }

    @Override
    public boolean isDirty(Object o, Object o1, boolean[] booleans, SharedSessionContractImplementor sharedSessionContractImplementor) throws HibernateException {
        return false;
    }

    @Override
    public boolean isModified(Object o, Object o1, boolean[] booleans, SharedSessionContractImplementor sharedSessionContractImplementor) throws HibernateException {
        return false;
    }

    @Override
    public Object nullSafeGet(ResultSet resultSet, String[] strings, SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException, SQLException {
        return null;
    }

    @Override
    public Object nullSafeGet(ResultSet resultSet, String s, SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException, SQLException {
        return null;
    }

    @Override
    public void nullSafeSet(PreparedStatement preparedStatement, Object o, int i, boolean[] booleans, SharedSessionContractImplementor sharedSessionContractImplementor) throws HibernateException, SQLException {

    }

    @Override
    public void nullSafeSet(PreparedStatement preparedStatement, Object o, int i, SharedSessionContractImplementor sharedSessionContractImplementor) throws HibernateException, SQLException {

    }

    @Override
    public String toLoggableString(Object o, SessionFactoryImplementor sessionFactoryImplementor) throws HibernateException {
        return "";
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public Object deepCopy(Object o, SessionFactoryImplementor sessionFactoryImplementor) throws HibernateException {
        return null;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object o, SharedSessionContractImplementor sharedSessionContractImplementor, Object o1) throws HibernateException {
        return null;
    }

    @Override
    public Object assemble(Serializable serializable, SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        return null;
    }

    @Override
    public void beforeAssemble(Serializable serializable, SharedSessionContractImplementor sharedSessionContractImplementor) {

    }

    @Override
    public Object hydrate(ResultSet resultSet, String[] strings, SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException, SQLException {
        return null;
    }

    @Override
    public Object resolve(Object o, SharedSessionContractImplementor sharedSessionContractImplementor, Object o1) throws HibernateException {
        return null;
    }

    @Override
    public Object semiResolve(Object o, SharedSessionContractImplementor sharedSessionContractImplementor, Object o1) throws HibernateException {
        return null;
    }

    @Override
    public Type getSemiResolvedType(SessionFactoryImplementor sessionFactoryImplementor) {
        return null;
    }

    @Override
    public Object replace(Object o, Object o1, SharedSessionContractImplementor sharedSessionContractImplementor, Object o2, Map map) throws HibernateException {
        return null;
    }

    @Override
    public Object replace(Object o, Object o1, SharedSessionContractImplementor sharedSessionContractImplementor, Object o2, Map map, ForeignKeyDirection foreignKeyDirection) throws HibernateException {
        return null;
    }

    @Override
    public boolean[] toColumnNullness(Object o, Mapping mapping) {
        return new boolean[0];
    }
}
