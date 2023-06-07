package org.vaadin.addons.mygroup;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

@PageTitle("Tabs")
@Route(value = "tabs", layout = MainLayout.class)
public class TabsView extends Main {

    public TabsView() {
        this.addClassNames(LumoUtility.Gap.SMALL);

        add(new H2("Contained"));
        add(createTabSheet(TabsTheme.CONTAINED));

        add(new H2("Classic"));
        add(createTabSheet(TabsTheme.CLASSIC));
    }

    private static TabSheet createTabSheet(String tabsTheme) {

        TabSheet tabSheet = new TabSheet();
        tabSheet.add(new Tab("Details"), new Span("First tab"));
        tabSheet.add(new Tab("Payment"), new Span("Second tab"));
        tabSheet.add(new Tab("Shipping"), new Span("Third tab"));
        tabSheet.addThemeName(tabsTheme);
        tabSheet.setWidthFull();

        return tabSheet;
    }

}
