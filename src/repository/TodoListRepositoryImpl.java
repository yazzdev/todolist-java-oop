package repository;

import entity.Todolist;

public class TodoListRepositoryImpl implements TodoListRepository{

  public Todolist[] data = new Todolist[10];

  @Override
  public Todolist[] getAll() {
    return data;
  }

  public boolean isFull(){
    // Cek apakah model penuh?
    var isFull = true;
    for (var i = 0; i < data.length; i++) {
      if (data[i] == null) {
        // Model masih ada yang kosong
        isFull = false;
        break;
      }
    }
    return isFull;
  }

  public void resizeIfFull(){
    // Jika penuh, resize ukuran array menjadi 2x lipat
    if (isFull()) {
      var temp = data;
      data = new Todolist[data.length * 2];

      for (var i = 0; i < temp.length; i++) {
        data[i] = temp[i];
      }
    }
  }

  @Override
  public void add(Todolist todolist) {

    resizeIfFull();

    // Tambahkan  ke posisi yang data array nya kosong/NULL
    for (var i = 0; i < data.length; i++) {
      if (data[i] == null) {
        data[i] = todolist;
        break;
      }
    }
  }

  @Override
  public void remove(Integer number) {

  }
}
