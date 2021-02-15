package com.bit.management.catalogs.screen;

import java.util.ArrayList;
import java.util.List;

public class MenuWrapperView {

	private MenuItemView parent;
	private List<MenuItemView> children = new ArrayList<>();

	public MenuItemView getParent() {
		return parent;
	}

	public void setParent(MenuItemView parent) {
		this.parent = parent;
	}

	public List<MenuItemView> getChildren() {
		return children;
	}

	public void setChildren(List<MenuItemView> children) {
		this.children = children;
	}
}
