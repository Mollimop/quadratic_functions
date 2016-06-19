class QuadraticFunction

  # Parameters of the function (abc for ax² + bx + c and ade for a(x + d)² + e
  @a ,@b ,@c ,@d ,@e

  # The vertex of the function
  @vertex

  # The zeroes of the function
  @zero1, @zero2

  # Three points of a function that are used to generate the function term.
  @p1, @p2, @p3

  # Initializes a function...
  def initialize(a, b, c, p1, p2, p3)
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
    @zero1 = Math.sqrt(-(@e / @a)) - @d
    @zero1 = - Math.sqrt(-(@e / @a)) - @d
  end

  #This method returns all images of a function for a Hash
  def getImagesOf(xes)
    images = {}
    xes.each do |num, x|
      images[num] = getImageOf(x)
    end
    return images
  end

  def generateABC()
    @a = ((@p1[:x] * (@p3[:y] - @p2[:y])) + (@p2[:x] * (@p1[:y] - @p3[:y])) + (@p3[:x] * (@p2[:y] - @p1[:y]))) / ((@p1[:x] - @p2[:x]) * (@p1[:x] - @p3[:x]) * (@p2[:x] - @p3[:x]))
    @b = (((@a * ((@p3[:x] * @p3[:x]) - (@p2[:x] * @p2[:x]))) + @p2[:y] - @p3[:y]) / (@p2[:x] - @p3[:x]));
    @c = (@p3[y]) - (@a * (@p3[:x] * @p3[:x])) - (@b * @p3[:x]);
  end
end
