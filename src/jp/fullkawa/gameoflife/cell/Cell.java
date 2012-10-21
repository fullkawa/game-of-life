package jp.fullkawa.gameoflife.cell;

import jp.fullkawa.gameoflife.Neighbors;
import jp.fullkawa.gameoflife.Position;
import jp.fullkawa.gameoflife.interaction.BirthAction;
import jp.fullkawa.gameoflife.interaction.InterActions;
import jp.fullkawa.gameoflife.interaction.LonelinessAction;
import jp.fullkawa.gameoflife.interaction.OverpopulationAction;
import jp.fullkawa.gameoflife.interaction.SurvivesAction;

public abstract class Cell {

	private Position position;
	private InterActions interactions;

	public Cell(int x, int y) {
		position = new Position(x, y);
		interactions = this.getInterActions();
	}

	public Position getPosition() {
		return position;
	}

	public int getX() {
		return position.getX();
	}

	public int getY() {
		return position.getY();
	}

	protected InterActions getInterActions() {
		InterActions actions = new InterActions();

		actions.add(new BirthAction());
		actions.add(new SurvivesAction());
		actions.add(new LonelinessAction());
		actions.add(new OverpopulationAction());

		return actions;
	}

	public Cell getNextGeneration(Neighbors neighbors) {
		Cell nextCell = this;

		if (interactions != null) {
			nextCell = interactions.getResult(this, neighbors);
		}
		return nextCell;
	}

	public abstract boolean isPopulated();
}
