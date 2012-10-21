package jp.fullkawa.gameoflife.cell;

import jp.fullkawa.gameoflife.interaction.InterActions;
import jp.fullkawa.gameoflife.interaction.LonelinessAction;
import jp.fullkawa.gameoflife.interaction.OverpopulationAction;
import jp.fullkawa.gameoflife.interaction.SurvivesAction;

public class PopulatedCell extends Cell {

	public PopulatedCell(int x, int y) {
		super(x, y);
	}

	@Override
	protected InterActions getInterActions() {
		InterActions actions = new InterActions();

		actions.add(new SurvivesAction());
		actions.add(new LonelinessAction());
		actions.add(new OverpopulationAction());

		return actions;
	}

	@Override
	public boolean isPopulated() {
		return true;
	}

	@Override
	public String toString() {
		return "■";
	}
}
