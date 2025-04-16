document.addEventListener('DOMContentLoaded', function () {
  // Fecha y hora de inicio
  flatpickr("#datetime-inicio", {
    enableTime: true,
    time_24hr: true,
    altInput: true,
    altFormat: "d/m/Y H:i",
    dateFormat: "Y-m-d H:i",
    onChange: function (selectedDates, dateStr) {
      const [fecha, hora] = dateStr.split(" ");
      document.getElementById("fechaInicio").value = fecha;
      document.getElementById("horaInicio").value = hora;
    }
  });

  // Fecha y hora de fin
  flatpickr("#datetime-fin", {
    enableTime: true,
    time_24hr: true,
    altInput: true,
    altFormat: "d/m/Y H:i",
    dateFormat: "Y-m-d H:i",
    onChange: function (selectedDates, dateStr) {
      const [fecha, hora] = dateStr.split(" ");
      document.getElementById("fechaFin").value = fecha;
      document.getElementById("horaFin").value = hora;
    }
  });
});
