#Milad Karimiyan
$counter=0

class DoubleSideStack

  def initialize()
    puts "Please enter lenghtof array?\t"
    @Max = gets.chomp.to_i
    $counter=@Max
    @Top = -1
    @TopE = @Max
    @myArray = Array.new(@Max)
  end
  def Push(item)
    if @Top<=@TopE
      if @Top == @Max-1
        puts "not enougth space"
        return @myArray[@Top]
      end
      @Top=@Top+1
      @myArray[@Top]=item
      puts "#{item} pushed"
      return @myArray[@Top]
    end
      raise "Conflict"
  end
  def Pop
    if @Top<=@TopE
      if @Top == -1
        puts "you are at first"
        return raise "Conflict"
      end
      @Top=@Top-1
      return @myArray[@Top+1]
    end
    raise "Conflict"
  end
  def PushFromEnd(item)
    if @Top<=@TopE
      if @Top == @Max
        puts "not enougth space"
        return false
      end
      @TopE=@TopE-1
      @myArray[@TopE]=item
      puts "#{item} pushed from end"
      return @myArray[@TopE]
    end
    raise "Conflict"
  end
  def PopFromEnd
    if @Top <= @TopE
      if @TopE == 0
        raise "Conflict"
      end
      @TopE=@TopE+1
      return @myArray[@TopE-1]
    end
    raise "Conflict"
  end
  def p
    puts @myArray
  end
end

  s1 = DoubleSideStack.new()
  for i in 0..($counter/2)-1
    s1.Push(gets.chomp.to_i)
  end

  for i in ($counter/2)..$counter-1
    s1.PushFromEnd(gets.chomp.to_i)
  end

  for i in 0..($counter/2)-1
    puts "#{s1.Pop}"
  end

  for i in ($counter/2)..$counter-1
    puts "#{s1.PopFromEnd}"
  end
