
public enum PagesEnum {
	
    IntroScreen("intro"),
    ImportScreen("import"),
    GuideScreen("guide"),
    InitializationScreen("initilize"),
    ModifyPlotScreen("modify"),
    PresentationModeScreen("presentation"),
    FaunaScreen("fauna"),
    SummaryScreen("summary"),
	BudgetScreen("budget"),
	SettingsScreen("settings");
	
	private String name = null;
	
	private PagesEnum(String s){
		name = s;
	}

	public String getName() {
		return name;
	}
    
}
