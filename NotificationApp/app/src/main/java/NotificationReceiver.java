import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class NotificationReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"image click", Toast.LENGTH_LONG).show();

        NotificationManagerCompat notificationCompat = NotificationManagerCompat.from(context);

        notificationCompat.cancel(8);
    }
}
