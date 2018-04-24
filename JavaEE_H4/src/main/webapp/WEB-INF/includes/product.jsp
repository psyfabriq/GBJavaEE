<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<ul class="products clearfix">


	<c:forEach items="${products}" var="item">
		<li class="product-wrapper"><a href="" class="product">
				<div class="product-main">
					<div class="product-photo">
						<img src="${item.img_path}" alt="">
						<div class="product-preview">
							<span class="button">Быстрый просмотр</span>
						</div>
					</div>
					<div class="product-text">
						<h2 class="produvt-name">
							<c:out value="${item.name}" />
						</h2>
						<p>
							<c:out value="${item.text}" />
						</p>
						<div class="product-icons">
							<div class="product-icons-item">
								<span class="icon icon-heart"></span> <span
									class="product-icon-text">В избранное</span>
							</div>
							<div class="product-icons-item">
								<span class="icon icon-balance"></span> <span
									class="product-icon-text">В сравнение</span>
							</div>
						</div>
					</div>
				</div>
				<div class="product-details-wrap">
					<div class="product-details">
						<div class="product-availability">
							<span class="icon icon-check"></span>В наличии
						</div>
						<span class="product-price product-price-old"> <b><c:out
									value="${item.old_cost}" /></b> <small>руб.</small>
						</span> <span class="product-price"> <b><c:out
									value="${item.cost}" /></b> <small>руб.</small>
						</span>
					</div>
					<div class="product-buttons-wrap">
						<div class="buttons">
							<span class="button to-cart"><span class="icon icon-cart"></span>В
								корзину</span> <span class="button">Купить в 1 клик</span>
						</div>
					</div>
				</div>
		</a></li>
	</c:forEach>

</ul>