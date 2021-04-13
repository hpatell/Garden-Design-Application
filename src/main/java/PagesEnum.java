
public enum PagesEnum {
	
    IntroScreen("intro", new IntroScreen()),
    ImportScreen("import", new ImportGardenScreen()),
    GuideScreen("guide", new GuideScreen()),
    IntializationScreen("initilize", new GardenInitializationScreen()),
    //ModifyPlotScreen("modify", new ModifyPlotScreen()),
    //PresentationModeScreen("presentation", new PresentationModeScreen()),
    FaunaScreen("fauna", new faunaScreen()),
    SummaryScreen("summary", new SummaryScreen());
    //GardenScreen("garden"),
	//BudgetScreen("budget", new BudgetScreen()),
	//SettingsScreen("settings");
	
	private String name = null;
	private Screen currentpage;
	
	private PagesEnum(String s, Screen screen){
		name = s;
		currentpage = screen;
	}

	public String getName() {
		return name;
	}
    
}
