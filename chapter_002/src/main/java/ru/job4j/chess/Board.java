package ru.job4j.chess;

import java.util.Arrays;
import java.util.List;

/**
 * Class Board.
 *
 * @author Artur Glyzin.
 * @version 2.0.
 * @since 11.12.2018.
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
        return Arrays.stream(steps)
                .filter(this::findCell)
                .findFirst().orElse(null) != null;
    }

    public boolean findCell(Cell step) {
        return Arrays.stream(figures)
                .filter(figure -> figure != null && figure.getPosition().equals(step))
                .findFirst().orElse(null) != null;
    }

    public void clean() {
        Arrays.stream(this.figures)
                .forEach(figure -> figure = null);
    }

    public int findFigure(Cell cell) {
        final int[] rst = {-1};
        List<Figure> figureList = Arrays.asList(this.figures);
        figureList.stream()
                .forEach(figure -> {
                    if (figure != null && figure.getPosition().equals(cell)) {
                        rst[0] = figureList.indexOf(figure);
                    }
                });
        return rst[0];
    }
}


