public class AppTodoListDasar {

  public static String[] model = new String[10];

  // Package untuk input data
  public static java.util.Scanner scanner = new java.util.Scanner(System.in);

  public static void main(String[] args) {
    viewShowTodoList();
  }

  /**
   * Business Logic
   */

  // Menampilkan todo list
  public static void showTodoList() {
    System.out.println("----------------");
    System.out.println(">>> TODOLIST <<<");
    for (var i = 0; i < model.length; i++) {
      var todo = model[i];
      var no = i + 1;

      if (todo != null) {
        System.out.println(no + ". " + todo);
      }
    }
  }

  static void testShowTodoList() {
    model[0] = "Belajar Java Dasar";
    model[1] = "Studi Kasus Java Dasar: Todolist";

    showTodoList();
  }

  // Menambahkan todo ke list
  public static void addTodoList(String todo) {
    // Cek apakah model penuh?
    var isFull = true;
    for (var i = 0; i < model.length; i++) {
      if (model[i] == null) {
        // Model masih ada yang kosong
        isFull = false;
        break;
      }
    }

    // Jika penuh, resize ukuran array menjadi 2x lipat
    if (isFull) {
      var temp = model;
      model = new String[model.length * 2];

      for (var i = 0; i < temp.length; i++) {
        model[i] = temp[i];
      }
    }

    // Tambahkan  ke posisi yang data array nya kosong/NULL
    for (var i = 0; i < model.length; i++) {
      if (model[i] == null) {
        model[i] = todo;
        break;
      }
    }
  }

  public static void testAddTodoList() {
    for (var i = 0; i < 25; i++) {
      addTodoList("Testing todo ke-" + i);
    }

    showTodoList();
  }

  // Menghapus todo dari list
  public static boolean removeTodoList(Integer number) {
    if ((number - 1) >= model.length) {
      return false;
    } else if (model[number - 1] == null) {
      return false;
    } else {
      for (int i = (number - 1); i < model.length; i++) {
        if (i == (model.length - 1)) {
          model[i] = null;
        } else {
          model[i] = model[i + 1];
        }
      }
      return true;
    }
  }

  public static void testRemoveTodoList() {
    addTodoList("satu");
    addTodoList("dua");
    addTodoList("tiga");
    addTodoList("empat");
    addTodoList("lima");

    System.out.println("Data Awal Setelah Tambah");
    showTodoList();
    var result = removeTodoList(20);
    System.out.println(result);

    System.out.println("Testing 1");
    showTodoList();
    result = removeTodoList(7);
    System.out.println(result);

    System.out.println("Testing 2");
    showTodoList();
    result = removeTodoList(2);
    System.out.println(result);

    System.out.println("Hasil Akhir Setelah Hapus");
    showTodoList();
  }

  // Input
  public static String input(String info) {
    System.out.print(info + " : ");
    String data = scanner.nextLine();
    return data;
  }

  public static void testInput() {
    var name = input("Nama");
    System.out.println("Hi " + name);

    var workingIn = input("Working in");
    System.out.println(workingIn);
  }

  /**
   * View
   */

  // View menampilkan todo list
  public static void viewShowTodoList() {
    while (true) {
      showTodoList();

      System.out.println("Menu");
      System.out.println("1. Tambah");
      System.out.println("2. Hapus");
      System.out.println("x. Keluar");

      var input = input("Pilih");

      if (input.equals("1")) {
        viewAddTodoList();
      } else if (input.equals("2")) {
        viewRemoveTodoList();
      } else if (input.equals("x")) {
        break;
      } else {
        System.out.println("Pilihan tidak sesuai");
      }
    }
  }

  public static void testViewShowTodoList() {
    addTodoList("satu");
    addTodoList("dua");
    addTodoList("tiga");
    addTodoList("empat");
    addTodoList("lima");

    viewShowTodoList();
  }

  // View menambahkan todo ke list
  public static void viewAddTodoList() {
    System.out.println(">> ADD TODO <<");

    var todo = input("Todo (x for cancel)");

    if (todo.equals("x")) {
      // batal
    } else {
      addTodoList(todo);
    }
  }

  public static void testViewAddTodoList() {
    addTodoList("satu");
    addTodoList("dua");

    viewAddTodoList();

    showTodoList();
  }

  // View menghapus todo dari list
  public static void viewRemoveTodoList() {
    System.out.println(">> REMOVE TODO <<");

    var number = input("Todo (x for cancel)");

    if (number.equals("x")) {
      // batal
    } else {
      boolean success = removeTodoList(Integer.valueOf(number));
      if (!success) {
        System.out.println("Gagal menghapus todolist : " + number);
      }
    }
  }

  public static void testViewRemoveTodoList(){
    addTodoList("satu");
    addTodoList("dua");
    addTodoList("tiga");

    showTodoList();

    viewRemoveTodoList();

    showTodoList();
  }
}