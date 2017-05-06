package org.superbiz.rest.dao;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.superbiz.rest.model.User;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;

import static org.junit.Assert.assertNotNull;

public class UserDaoTest {

    private static EJBContainer container;

    @BeforeClass
    public static void start() {
        container = EJBContainer.createEJBContainer();
    }

    @AfterClass
    public static void stop() {
        if (container != null) {
            container.close();
        }
    }

    @Test
    public void create() throws NamingException {
        final UserDAO dao = (UserDAO) container.getContext().lookup("java:global/war-with-resource/UserDAO");
        final User user = dao.create("foo", "dummy", "foo@bar.org");
        assertNotNull(dao.find(user.getId()));
    }
}
