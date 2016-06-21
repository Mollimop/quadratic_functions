class MainController < ApplicationController
  def index
    @func = QuadraticFunction.new
  end
  def calc
    a = func_params[:a].to_f
    b = func_params[:b].to_f
    c = func_params[:c].to_f
    func = QuadraticFunction.new(a, b, c)
    @vertex = func.vertex
  end

  private def func_params
    params.require(:quadratic_function).permit(:a, :b, :c)
  end
end
