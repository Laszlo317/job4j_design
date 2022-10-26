# job4j_design
Уравнение {\displaystyle {\frac {dx}{dt}}=f(t,x)}{\frac  {dx}{dt}}=f(t,x) с начальным условием {\displaystyle x(t_{0})=x_{0}}x(t_{0})=x_{0} эквивалентно интегральному уравнению {\displaystyle x(t)=x_{0}+\int \limits _{t_{0}}^{t}f(\tau ,x(\tau ))d\tau }x(t)=x_{0}+\int \limits _{{t_{{0}}}}^{t}f(\tau ,x(\tau ))d\tau .

Рассмотрим оператор A, определенный равенством {\displaystyle A(x)\equiv x_{0}+\int \limits _{t_{0}}^{t}f(\tau ,x(\tau ))d\tau }A(x)\equiv x_{0}+\int \limits _{{t_{{0}}}}^{t}f(\tau ,x(\tau ))d\tau  в пространстве {\displaystyle C[t_{0}-h,t_{0}+h]}C[t_{{0}}-h,t_{{0}}+h] на шаре {\displaystyle S_{b}:||x-x_{0}||\leqslant b}S_{b}:||x-x_{0}||\leqslant b, который будет замкнутым выпуклым множеством в этом пространстве.

Оператор A вполне непрерывен на этом шаре. Если последовательность {\displaystyle {\mathcal {f}}x_{n}(t){\mathcal {g}}}{\mathcal  {f}}x_{n}(t){\mathcal  {g}}, принадлежащая шару {\displaystyle |x-x_{0}|\leqslant b}|x-x_{0}|\leqslant b, равномерно сходится к функции {\displaystyle x(t)\in S_{b}}x(t)\in S_{b}, то в силу непрерывности функции {\displaystyle f(t,x)}f(t,x) имеем, что {\displaystyle f(t,x_{n}(t))\rightarrow f(t,x(t))}f(t,x_{n}(t))\rightarrow f(t,x(t)) равномерно на {\displaystyle [t_{0}-h,t_{0}+h]}[t_{0}-h,t_{0}+h]. При равномерной сходимости законен предельный переход под знаком интеграла, так что {\displaystyle Ax_{n}\rightarrow Ax}Ax_{n}\rightarrow Ax, то есть оператор A непрерывен на шаре {\displaystyle S_{b}}S_{b}.

Для любого элемента {\displaystyle x(t)\in S_{b}}x(t)\in S_{b} выполняется неравенство {\displaystyle |Ax(t)|\leqslant |x_{0}|+|\int \limits _{t_{0}}^{t}f(\tau ,x(\tau ))d\tau \leqslant |x_{0}|+\beta |h|}|Ax(t)|\leqslant |x_{0}|+|\int \limits _{{t_{{0}}}}^{t}f(\tau ,x(\tau ))d\tau \leqslant |x_{0}|+\beta |h|, то есть множество значений оператора {\displaystyle A}A ограничено.

Если {\displaystyle t_{1}}t_{1} и {\displaystyle t_{2}}t_{2} — любые точки отрезка {\displaystyle [t_{0}-h,t_{0}+h]}[t_{0}-h,t_{0}+h], то для любой функции {\displaystyle x(t)\in S_{b}}x(t)\in S_{b} будем иметь {\displaystyle |Ax(t_{2})-Ax(t_{1})|\leqslant |\int \limits _{t_{1}}^{t_{2}}f(\tau ,x(\tau ))d\tau |\leqslant \beta |t_{2}-t_{1}|}|Ax(t_{{2}})-Ax(t_{{1}})|\leqslant |\int \limits _{{t_{{1}}}}^{{t_{{2}}}}f(\tau ,x(\tau ))d\tau |\leqslant \beta |t_{{2}}-t_{{1}}|, то есть множество значений оператора {\displaystyle A}A равностепенно непрерывно.

В силу теоремы Арцела отсюда заключаем, что оператор {\displaystyle A}A преобразует шар {\displaystyle S_{b}:||x-x_{0}||\leqslant b}S_{b}:||x-x_{0}||\leqslant b в компактное множество.

Это доказывает полную непрерывность оператора {\displaystyle A}A.

Оператор {\displaystyle A}A преобразует шар {\displaystyle S_{b}:||x-x_{0}||\leqslant b}S_{b}:||x-x_{0}||\leqslant b в себя. Действительно, {\displaystyle |Ax(t)-x_{0})|\leqslant |\int \limits _{t_{0}}^{t}f(\tau ,x(\tau ))d\tau |\leqslant \beta h\leqslant \beta {\frac {b}{\beta }}=b}|Ax(t)-x_{0})|\leqslant |\int \limits _{{t_{{0}}}}^{{t}}f(\tau ,x(\tau ))d\tau |\leqslant \beta h\leqslant \beta {\frac  {b}{\beta }}=b.

Таким образом, оператор {\displaystyle A}A удовлетворяет всем условиям теоремы Шаудера. Существует неподвижная точка этого оператора, то есть такая функция {\displaystyle {\tilde {x}}(t)}{\tilde  {x}}(t), что {\displaystyle {\tilde {x}}(t)\equiv x_{0}+\int \limits _{t_{0}}^{t}f(\tau ,{\tilde {x}}(\tau ))d\tau }{\tilde  {x}}(t)\equiv x_{0}+\int \limits _{{t_{{0}}}}^{{t}}f(\tau ,{\tilde  {x}}(\tau ))d\tau .

Эта функция {\displaystyle {\tilde {x}}(t)}{\tilde  {x}}(t) будет решением уравнения {\displaystyle {\frac {dx}{dt}}=f(t,x)}{\frac  {dx}{dt}}=f(t,x), удовлетворяющим начальному условию {\displaystyle x(t_{0})=x_{0}}x(t_{0})=x_{0}.
