class MainController < ApplicationController
  def index
    @func = QuadraticFunction.new
  end
  def calc
    a = func_params[:a].to_f
    b = func_params[:b].to_f
    c = func_params[:c].to_f
    start = params[:start].to_f
    step = params[:step].to_f
    theend = params[:end].to_f
    unless a == 0
      func = QuadraticFunction.new(a, b, c)
      @vertex = func.vertex
      @zero1 = func.zero1
      @zero2 = func.zero2
      @images = func.getImagesOf2(start, theend, step) unless ((step == 0) || (step >= theend - start))
    end
  end

  private def func_params
    params.require(:quadratic_function).permit(:a, :b, :c)
  end
end
