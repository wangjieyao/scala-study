import java.text.MessageFormat

/**
  *
  * 《快学scala》第二章
  *
  * @author wangjieyao
  * @Date 2018/8/3 18:09
  */
object Chapter2 {

  def main(args: Array[String]): Unit = {

    for {
      i <- 1 to 3
      j <- 1 to 3
    }
      print(10 * i + j + " ")


    for( i <- 1 to 3)
       yield i % 3


    scala.math.abs(2)
    print(fuc(10))


    def fuc(n:Int) :Int = {
      if (n > 0){
        fuc(n-1) + n
      } else{
        1
      }
    }
    //默认参数与带名参数
    def fuc1(str: String, left: String = "[", right: String = "]") =
      left + str + right

    println(fuc1("hello"))
    println(fuc1("hello", "<<<",">>>"))
    println(fuc1(left = "{",str = "world"))

    //变长参数
    def sum(args : Int*) ={
      var result = 0
      for ( arg <- args) result += arg
      result
    }
    println(sum(1,2))
    //错误的
    //sum( 1 to 3)
    println(sum(1 to 3 :_*))
    println(MessageFormat.format("test {1},{2}","hello", 42.asInstanceOf[AnyRef]))

    //过程
    def fuc2(n:Int): Unit ={
      println(n)
    }
    fuc2(11)

    //懒值
    //定义的时候即加载,路径找不到 报错
//    val words = scala.io.Source.fromFile("E:\\work\\ss.txt").mkString
    //首次使用的时候加载，不会报错
    lazy val words1 = scala.io.Source.fromFile("E:\\work\\ss.txt").mkString
    //每次使用的时候加载，不会报错
    def words2 = scala.io.Source.fromFile("E:\\work\\ss.txt").mkString

    //异常
    def fuc3(n : Int) = {
      if (n > 0 ) {
        scala.math.abs(n)
      } else throw new Exception("test")

    }
    println(fuc3(-1))

  }

}
