package Helper;

import enums.enums.Direction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Set {
  public int row;
  public int col;
  public Direction dir;

  public static HashMap<Integer,List<Set>> getSet(){


      HashMap<Integer,List<Set>> rowCol = new HashMap();

      List<Set> newSet = new ArrayList();
      //set 2
      Set s = new Set();
      s.row =2;
      s.col =2;
      s.dir = Direction.HORIZONTAL;
      newSet.add(s);
      s = new Set();
      s.row =4;
      s.col =3;
      s.dir = Direction.VERTICAL;
      newSet.add(s);
      s = new Set();
      s.row = 9;
      s.col = 5;
      s.dir = Direction.HORIZONTAL;
      newSet.add(s);
      rowCol.put(2,newSet);

      return rowCol;

  }
}
