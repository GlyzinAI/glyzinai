package ru.job4j.chess;

/**
 * Class Board.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 09.09.2018.
 */

public class Board {

    private Figure[] figures = new Figure[2];
    private int position = 0;

    /**
     * Add figure.
     *
     * @param figure figure.
     */

    public void add(Figure figure) {
        this.figures[this.position++] = figure;
    }

    /**
     * Move figure.
     *
     * @param source source position.
     * @param dest   position destination.
     * @return true if figure move.
     * @throws ImposibleMoveException
     * @throws OccupiedWayException
     * @throws FigureNotFoundException
     */

    public boolean move(Cell source, Cell dest) throws FigureNotFoundException, ImposibleMoveException, OccupiedWayException {
        int index = findFigure(source);
        if (index < 0) {
            throw new FigureNotFoundException("Figure not found!");
        }
        Cell[] steps = this.figures[index].way(source, dest);
        if (occupiedWay(steps)) {
            throw new OccupiedWayException("Occupied way!");
        }

        this.figures[index] = this.figures[index].copy(dest);
        return true;
    }

    public boolean occupiedWay(Cell[] steps) {
        boolean result = false;
        for (Cell step : steps) {
            if (this.findCell(step)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean findCell(Cell step) {
        boolean res = false;
        for (Figure figure : figures) {
            if (figure != null && figure.getPosition().equals(step)) {
                res = true;
                break;
            }
        }
        return res;
    }

    public void clean() {
        this.figures = new Figure[32];
    }

    public int findFigure(Cell cell) {
        int index = -1;
        for (int i = 0; i < figures.length; i++) {
            if (figures[i] != null && figures[i].getPosition().equals(cell)) {
                index = i;
                break;
            }
        }
        return index;
    }
}


