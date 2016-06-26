class QuadraticFunction

  extend ActiveModel::Naming
  include ActiveModel::Conversion
  def persisted?
    false
  end

  # Parameters of the function (abc for ax² + bx + c and ade for a(x + d)² + e
  @a
  @b
  @c
  @d
  @e

  # The vertex of the function
  @vertex

  # The zeroes of the function
  @zero1
  @zero2

  # Three points of a function that are used to generate the function term.
  @p1
  @p2
  @p3

  # Initializes a function...
  def initialize(*smth)
    a = smth[0]
    b = smth[1]
    c = smth[2]
    p1 = smth[3]
    p2 = smth[4]
    p3 = smth[5]
    # ...with a, b and c and generates d, e, the vertex and the zeroes
    if(a && b && c)
      raise "Illegal Argument" if a == 0
      @a = a
      @b = b
      @c = c
      generateVertex()
      generateZero()
    # ...with p1, p2, p3 and generates a, b, c, d, e the evrtex and the zeroes
  elsif(p1 && p2 && p3)
      @p1 = p1
      @p2 = p2
      @p3 = p3
      generateABC()
      generateVertex()
      generateZero()
    end
  end

  # attr_reader
  attr_reader :a, :b, :c, :d, :e, :vertex, :p1, :p2, :p3, :zero1, :zero2

  # Calculates y of the function for a given x
  def getImageOf(x)
    @a * x * x + @b * x + @c
  end

  #Generates the parameters d and e of the function f(x) = a(x + d)² + e
  #Used in constructor QuadraticFunction(double a, double b, double c)
  def generateVertex()
    @d = @b / (2 * @a)
    @e = (4 * @a * @c - @b * @b) / (4 * @a)
    @vertex = {x: -@d, y: @e}
  end

  # Generates the zeroes of the function
  def generateZero()
    if (-(@e / @a) >= 0)
      @zero1 = Math.sqrt(-(@e / @a)) - @d
      @zero2 = - Math.sqrt(-(@e / @a)) - @d
    else
      @zero1 = "NaN"
      @zero2 = "NaN"
    end
  end

  #This method returns all images of a function for a flexible number of arguments
  def getImagesOf(*xes)
    images = Array.new()
    i = 0
    xes.each do |x|
      images[i] = getImageOf(x)
      i += 1 unless i == xes.length
    end
    return images
  end

  def generateABC()
    @a = ((@p1[:x] * (@p3[:y] - @p2[:y])) + (@p2[:x] * (@p1[:y] - @p3[:y])) + (@p3[:x] * (@p2[:y] - @p1[:y]))) / ((@p1[:x] - @p2[:x]) * (@p1[:x] - @p3[:x]) * (@p2[:x] - @p3[:x]))
    @b = (((@a * ((@p3[:x] * @p3[:x]) - (@p2[:x] * @p2[:x]))) + @p2[:y] - @p3[:y]) / (@p2[:x] - @p3[:x]));
    @c = (@p3[:y]) - (@a * (@p3[:x] * @p3[:x])) - (@b * @p3[:x]);
  end

  # This method returns all images of a function with x starting with start, ending with end and
  def getImagesOf2(start, theend, step)
    many = (theend - start) / step
    many = many.to_i
    i = start
    images = {}
    many.times do |n|
      images[i.to_s.to_sym] = getImageOf(i)
      i += step
    end
    return images
  end

  # Generates a string of the function like ax²+ bx + c
  def toNormalString()
    part1
    part2
    part3

    part1 = a + "x²"

    if (b > 0)
      part2 = " + " + b + "x"
    elsif (b < 0)
      part2 = " - " + -b + "x"
    else
      part2 = ""
    end

    if (c > 0)
      part3 = " + " + c
    elsif (c < 0)
      part3 = " - " + -c
    else
      part3 = ""
    end

    return part1 + part2 + part3;
  end

  # Generates a string of the function like a(x + d)²+ e
  def toVertexString()
    part1
    part2

    if (d > 0)
      part1 = a + "(x + " + d + ")²"
    elsif (d < 0)
      part1 = a + "(x - " + -d + ")²"
    else
      part1 = a + "x²"
    end

    if (e > 0)
      part2 = " + " + e
    elsif (e < 0)
      part2 = " - " + -e
    else
      part2 = ""
    end

    return part1 + part2
  end

  # Generates a string for the zeroes
  def toZeroString()
    if (a / e < 0)
      return zero1 + ", " + zero2
    else
      return "No zeroes"
    end
  end


end


# Example for what you can do with that class!
#puts "gimme a"
#a = gets.chomp
#puts "gimme b"
#b = gets.chomp
#puts "gimme c"
#c = gets.chomp
#func = QuadraticFunction.new(a.to_f, b.to_f, c-to_f)

#puts "gimme start"
#start = gets.chomp
#puts "gimme theend"
#theend = gets.chomp
#puts "gimme step"
#step = gets.chomp

#puts func.getImagesOf2(start.to_f, theend.to_f, step.to_f)
