package org.vaadin.addons.mygroup;


import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.RouterLink;

@CssImport("../src/test/java/org/vaadin/addons/mygroup/styles/navigation.css")
@CssImport(value = "../src/test/java/org/vaadin/addons/mygroup/styles/vaadin-app-layout.css", themeFor = "vaadin-app-layout")

/**
 * The main view is a top-level placeholder for other views.
 */
public class MainLayout extends AppLayout {

	private H1 viewTitle;

	public MainLayout() {
		setPrimarySection(Section.DRAWER);
		addToNavbar(true, createHeaderContent());
		addToDrawer(createDrawerContent());
	}

	private Component createHeaderContent() {
		DrawerToggle toggle = new DrawerToggle();
		toggle.addClassNames("view-toggle");
		toggle.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
		toggle.getElement().setAttribute("aria-label", "Menu toggle");

		viewTitle = new H1();
		viewTitle.addClassNames("view-title");

		Header header = new Header(toggle, viewTitle);
		header.addClassNames("view-header");
		return header;
	}

	private Component createDrawerContent() {
		H2 appName = new H2("Vaadin+");
		appName.addClassNames("app-name");

		com.vaadin.flow.component.html.Section section = new com.vaadin.flow.component.html.Section(appName,
				createNavigation());
		section.addClassNames("drawer-section");
		return section;
	}

	private Nav createNavigation() {
		Nav nav = new Nav();
		nav.addClassNames("menu-item-container");
		nav.getElement().setAttribute("aria-labelledby", "views");

		// Wrap the links in a list; improves accessibility
		UnorderedList list = new UnorderedList();
		list.addClassNames("navigation-list");
		nav.add(list);

		for (MenuItemInfo menuItem : createMenuItems()) {
			list.add(menuItem);

		}
		return nav;
	}

	private MenuItemInfo[] createMenuItems() {
		return new MenuItemInfo[]{
				new MenuItemInfo("Checkboxes", CheckboxesView.class),
				new MenuItemInfo("Radio Buttons", RadioButtonsView.class),
				new MenuItemInfo("Seqmented Controls", SegmentedControlsView.class),
				new MenuItemInfo("Input Groups", InputGroupsView.class),
		};
	}

	@Override
	protected void afterNavigation() {
		super.afterNavigation();
		viewTitle.setText(getCurrentPageTitle());
	}

	private String getCurrentPageTitle() {
		PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
		return title == null ? "" : title.value();
	}

	/**
	 * A simple navigation item component, based on ListItem element.
	 */
	public static class MenuItemInfo extends ListItem {

		private final Class<? extends Component> view;

		public MenuItemInfo(String menuTitle, Class<? extends Component> view) {
			this.view = view;
			RouterLink link = new RouterLink();
			link.addClassNames("menu-item-link");
			link.setRoute(view);
			link.add(new Span(menuTitle));

			add(link);
		}

	}
}
