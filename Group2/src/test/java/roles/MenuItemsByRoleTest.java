package roles;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import roles.interfaces.IMenuItemsByRole;
import roles.interfaces.IRoleManagementDao;

public class MenuItemsByRoleTest {
	
	private final String USER_TYPE = "End_User";
	private final String NULL_OBJECT = null;
	private final String EMPTY = "";
	private final String CREATE_TICKET = "Create ticket";
	private final String INVALID_USER_TYPE = "ABC";
	
	private IMenuItemsByRole menuItemsByRole;
	private IRoleManagementDao roleManagementDao;

	@Before
	public void init() {
		roleManagementDao = new RoleManagementDaoMock();
		menuItemsByRole = new MenuItemsByRole(roleManagementDao);
	}

	@Test
	public void  createUserTaskMenuTest() throws Exception {
		List<String> menuItemsList = menuItemsByRole.fetchMenuItemsByRole(USER_TYPE);
		boolean isMenuItemsListSizeGreaterThan0 = menuItemsList.size() > 0;
		assertTrue(isMenuItemsListSizeGreaterThan0);
		assertTrue(menuItemsList.contains(CREATE_TICKET));
	}
	
	@Test
	public void  createUserTaskMenuInvalidUserTypeTest() throws Exception {
		List<String> menuItemsList = menuItemsByRole.fetchMenuItemsByRole(INVALID_USER_TYPE);
		assertNull(menuItemsList);
	}
	
	@Test
	public void  createUserTaskMenuNullTest() throws Exception {
		List<String> menuItemsList = menuItemsByRole.fetchMenuItemsByRole(NULL_OBJECT);
		assertNull(menuItemsList);
	}
	
	@Test
	public void  createUserTaskMenuEmptyTest() throws Exception {
		List<String> menuItemsList = menuItemsByRole.fetchMenuItemsByRole(EMPTY);
		assertNull(menuItemsList);
	}
}
