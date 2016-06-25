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

    if ((a == 0) || ((theend - start) > 1000) || (step < 0.001) )
      redirect_to action: "index" and return
    end

    func = QuadraticFunction.new(a, b, c)
    @vertex = func.vertex
    @zero1 = func.zero1
    @zero2 = func.zero2
    @images = func.getImagesOf2(start, theend, step) unless ((step == 0) || (step >= theend - start))
  end

  def calcpoints
    p1 = {x: params[:p1_x].to_f, y: params[:p1_y].to_f}
    p2 = {x: params[:p2_x].to_f, y: params[:p2_y].to_f}
    p3 = {x: params[:p3_x].to_f, y: params[:p3_y].to_f}
    start = params[:start].to_f
    step = params[:step].to_f
    theend = params[:end].to_f

    if (((theend - start) > 1000) || (step < 0.001))
      redirect_to action: "index" and return
    end

    func = QuadraticFunction.new(false, false, false, p1, p2, p3)
    @vertex = func.vertex
    @zero1 = func.zero1
    @zero2 = func.zero2
    @images = func.getImagesOf2(start, theend, step) unless ((step == 0) || (step >= theend - start))

    render "calc"
  end

  private def func_params
    params.require(:quadratic_function).permit(:a, :b, :c)
  end
end
