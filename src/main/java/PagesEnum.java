	/**
	 * Used to create the enum associated to all screen
	 * @author Kush Patel
	 */
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
	SettingsScreen("settings"),
	PreviousScreen("Previous");
	
	private String name = null;
	
	/**
	 * Takes in the name of a garden screen
	 * @param s Takes in the name of a garden screen
	 * @author Kush Patel
	 */
	private PagesEnum(String s){
		name = s;
	}

	/**
	 * Gets the name of a garden screen
	 * @return returns the name of a garden screen
	 * @author Kush Patel
	 */
	public String getName() {
		return name;
	}
    
}
