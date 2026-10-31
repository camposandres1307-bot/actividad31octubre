package MainActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.CalendarView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 1. Crear el contenedor principal (LinearLayout vertical) por código
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER);
        layout.setPadding(32, 32, 32, 32);

        // 2. Crear y configurar el CalendarView
        CalendarView calendarView = new CalendarView(this);
        LinearLayout.LayoutParams calendarParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        calendarParams.setMargins(0, 0, 0, 50);
        calendarView.setLayoutParams(calendarParams);

        // 3. Crear y configurar el TextView para mostrar la fecha
        TextView tvFechaSeleccionada = new TextView(this);
        tvFechaSeleccionada.setText("Selecciona una fecha");
        tvFechaSeleccionada.setTextSize(18);
        tvFechaSeleccionada.setTextColor(Color.DKGRAY);
        tvFechaSeleccionada.setGravity(Gravity.CENTER);

        // 4. Agregar los componentes al diseño principal
        layout.addView(calendarView);
        layout.addView(tvFechaSeleccionada);

        // 5. Asignar el layout completo a la pantalla principal
        setContentView(layout);

        // 6. Programar la lógica cuando el usuario seleccione una fecha en el calendario
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                // El mes en Android comienza en 0 (Enero = 0), por eso sumamos +1
                int mesReal = month + 1;
                String fechaFormateada = dayOfMonth + "/" + mesReal + "/" + year;

                // Actualizar el texto y mostrar un mensaje flotante
                tvFechaSeleccionada.setText("Fecha seleccionada: " + fechaFormateada);
                Toast.makeText(MainActivity.this, "Seleccionaste: " + fechaFormateada, Toast.LENGTH_SHORT).show();
            }
        });
    }
}