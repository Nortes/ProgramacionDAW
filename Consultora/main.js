(function () {
  const cards = document.querySelectorAll(".plan-card");
  const details = document.querySelectorAll(".producto-panel .detalle");

  function resetView() {
    details.forEach(sec => {
      const isIntro = sec.id === "detalle-intro";
      sec.hidden = !isIntro;
      sec.classList.toggle("is-active", isIntro);
    });

    cards.forEach(btn => {
      btn.classList.remove("is-active");
      btn.setAttribute("aria-expanded", "false");
    });
  }

  function show(targetId) {
    details.forEach(sec => {
      const isTarget = sec.id === targetId;
      sec.hidden = !isTarget;
      sec.classList.toggle("is-active", isTarget);
    });

    cards.forEach(btn => {
      const isActive = btn.dataset.target === targetId;
      btn.classList.toggle("is-active", isActive);
      btn.setAttribute("aria-expanded", isActive ? "true" : "false");
    });
  }

  // Estado inicial neutro
  resetView();

  cards.forEach(btn => {
    btn.addEventListener("click", () => {
      show(btn.dataset.target);
    });
  });
})();

